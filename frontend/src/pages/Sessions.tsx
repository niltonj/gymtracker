import { useState } from "react";
import { api } from "../lib/api";

export default function Sessions(){
  const [date, setDate] = useState("");
  const [exerciseId, setExerciseId] = useState("");
  const [sessionId, setSessionId] = useState<string|undefined>();

  const createSession = async ()=>{
    const res = await api.post('/sessions', { sessionDate: date });
    setSessionId(res.data.id);
  };

  const addSet = async ()=>{
    if(!sessionId) return;
    await api.post(`/sessions/${sessionId}/sets`, {
      exerciseId, setIndex: 1, reps: 10, weightKg: 20.0
    });
    alert('Set added');
  };

  return (
    <div className="space-y-4">
      <h1 className="text-2xl font-semibold">Sessions</h1>
      <div className="flex gap-2">
        <input className="border rounded px-3 py-2" type="date" value={date} onChange={e=>setDate(e.target.value)} />
        <button className="px-4 py-2 rounded bg-black text-white" onClick={createSession}>Create Session</button>
      </div>
      <div className="flex gap-2">
        <input className="border rounded px-3 py-2" placeholder="Exercise UUID" value={exerciseId} onChange={e=>setExerciseId(e.target.value)} />
        <button className="px-4 py-2 rounded bg-black text-white" onClick={addSet} disabled={!sessionId}>Add Set</button>
      </div>
      {sessionId && <p className="text-sm">Current session: {sessionId}</p>}
    </div>
  );
}
