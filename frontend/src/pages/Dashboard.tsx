import { useEffect, useState } from "react";
import { LineChart, Line, XAxis, YAxis, Tooltip, CartesianGrid, ResponsiveContainer } from "recharts";

type PR = { date: string; weight: number };

export default function Dashboard(){
  const [data, setData] = useState<PR[]>([]);
  useEffect(()=>{
    setData([
      { date: '2025-01-01', weight: 60 },
      { date: '2025-03-01', weight: 70 },
      { date: '2025-06-01', weight: 72.5 },
    ]);
  },[]);

  return (
    <div className="space-y-6">
      <h1 className="text-2xl font-semibold">Dashboard</h1>
      <div className="h-72 w-full">
        <ResponsiveContainer width="100%" height="100%">
          <LineChart data={data}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="date" />
            <YAxis />
            <Tooltip />
            <Line type="monotone" dataKey="weight" />
          </LineChart>
        </ResponsiveContainer>
      </div>
    </div>
  );
}
