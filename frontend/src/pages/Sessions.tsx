import { useState } from "react";
import { api } from "../lib/api";

export default function Sessions(){
  const [date, setDate] = useState("");
  const [exerciseId, setExerciseId] = useState("");
  const [sessionId, setSessionId] = useState<string|undefined>();
  const [nextSetIndex, setNextSetIndex] = useState(1);

  const createSession = async ()=>{
    const res = await api.post('/sessions', { sessionDate: date });
    setSessionId(res.data.id);
    setNextSetIndex(1);
  };

  const addSet = async ()=>{
    if(!sessionId) return;
    await api.post(`/sessions/${sessionId}/sets`, {
      exerciseId,
      setIndex: nextSetIndex,
      reps: 10,
      weightKg: 20.0
    });
    setNextSetIndex(nextSetIndex + 1);
    alert('Set added');
  };

  return (
    <div className="space-y-4">
      <h1 className="text-2xl font-semibold">Sessions</h1>
      <div className="flex flex-col sm:flex-row gap-2">
        <input className="border rounded px-3 py-2 flex-1" type="date" value={date} onChange={e=>setDate(e.target.value)} />
        <button className="px-4 py-2 rounded bg-black text-white whitespace-nowrap" onClick={createSession}>Create Session</button>
      </div>
      <div className="flex flex-col sm:flex-row gap-2">
        <input className="border rounded px-3 py-2 flex-1" placeholder="Exercise UUID" value={exerciseId} onChange={e=>setExerciseId(e.target.value)} />
        <button className="px-4 py-2 rounded bg-black text-white whitespace-nowrap" onClick={addSet} disabled={!sessionId}>Add Set</button>
      </div>
      {sessionId && <p className="text-sm break-words">Current session: {sessionId}</p>}
    </div>
  );
}
