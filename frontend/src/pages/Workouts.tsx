import { useEffect, useState } from "react";

type ExerciseEntry = {
  name: string;
  weight: string;
  reps: string;
};

const STORAGE_KEY = "workout";

export default function Workouts() {
  const [exercise, setExercise] = useState("");
  const [weight, setWeight] = useState("");
  const [reps, setReps] = useState("");
  const [list, setList] = useState<ExerciseEntry[]>([]);

  useEffect(() => {
    const saved = localStorage.getItem(STORAGE_KEY);
    if (saved) {
      try {
        setList(JSON.parse(saved));
      } catch {
        // ignore malformed saved data
      }
    }
  }, []);

  const addExercise = () => {
    if (!exercise || !weight || !reps) return;
    setList([...list, { name: exercise, weight, reps }]);
    setExercise("");
    setWeight("");
    setReps("");
  };

  const saveWorkout = () => {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(list));
    alert("Workout saved");
  };

  return (
    <div className="space-y-4">
      <h1 className="text-2xl font-semibold">New Workout</h1>
      <div className="flex gap-2">
        <input
          className="border rounded px-3 py-2 flex-1"
          placeholder="Exercise"
          value={exercise}
          onChange={(e) => setExercise(e.target.value)}
        />
        <input
          className="border rounded px-3 py-2 w-24"
          type="number"
          placeholder="Weight (kg)"
          value={weight}
          onChange={(e) => setWeight(e.target.value)}
        />
        <input
          className="border rounded px-3 py-2 w-24"
          type="number"
          placeholder="Reps"
          value={reps}
          onChange={(e) => setReps(e.target.value)}
        />
        <button
          className="px-4 py-2 rounded bg-black text-white"
          onClick={addExercise}
        >
          Add
        </button>
      </div>

      {list.length > 0 && (
        <div className="overflow-x-auto">
          <table className="w-full text-left border">
            <thead>
              <tr className="bg-gray-100">
                <th className="px-3 py-2 border-r">Exercise</th>
                <th className="px-3 py-2 border-r">Weight (kg)</th>
                <th className="px-3 py-2">Reps</th>
              </tr>
            </thead>
            <tbody>
              {list.map((item, idx) => (
                <tr key={idx} className="border-t">
                  <td className="px-3 py-2 border-r">{item.name}</td>
                  <td className="px-3 py-2 border-r">{item.weight}</td>
                  <td className="px-3 py-2">{item.reps}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

      <button
        className="px-4 py-2 rounded bg-black text-white"
        onClick={saveWorkout}
        disabled={list.length === 0}
      >
        Save Workout
      </button>
    </div>
  );
}

