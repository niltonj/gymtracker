import { Outlet } from "react-router-dom";
export default function App(){
  return (
    <div className="min-h-screen flex">
      <aside className="w-60 border-r p-4">GymTracker</aside>
      <main className="flex-1 p-6"><Outlet /></main>
    </div>
  );
}
