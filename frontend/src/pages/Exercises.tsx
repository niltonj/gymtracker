import { useQuery, useMutation } from "@tanstack/react-query";
import { api } from "../lib/api";
import { useState } from "react";

type Exercise = { id: string; name: string; muscleGroup: string };

export default function Exercises(){
  const { data } = useQuery({
    queryKey: ['exercises'],
    queryFn: async ()=> (await api.get<Exercise[]>('/exercises')).data
  });
  const [name, setName] = useState("");
  const [group, setGroup] = useState("");
  const create = useMutation({
    mutationFn: async ()=> (await api.post('/exercises', { name, muscleGroup: group })).data,
    onSuccess:()=>window.location.reload()
  });

  return (
    <div className="space-y-4">
      <h1 className="text-2xl font-semibold">Exercises</h1>
      <div className="flex gap-2">
        <input className="border rounded px-3 py-2" placeholder="Name" value={name} onChange={e=>setName(e.target.value)} />
        <input className="border rounded px-3 py-2" placeholder="Muscle group" value={group} onChange={e=>setGroup(e.target.value)} />
        <button className="px-4 py-2 rounded bg-black text-white" onClick={()=>create.mutate()}>Add</button>
      </div>
      <ul className="list-disc pl-6">
        {data?.map(e=> <li key={e.id}>{e.name} — <span className="text-sm text-gray-500">{e.muscleGroup}</span></li>)}
      </ul>
    </div>
  );
}
