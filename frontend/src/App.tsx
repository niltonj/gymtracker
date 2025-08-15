import { NavLink, Outlet } from "react-router-dom";

export default function App() {
  const linkClass = ({ isActive }: { isActive: boolean }) =>
    `block px-3 py-2 rounded hover:bg-gray-100 ${isActive ? "bg-gray-200 font-medium" : ""}`;

  return (
    <div className="min-h-screen flex">
      <aside className="w-60 border-r p-4 space-y-4">
        <h1 className="text-xl font-semibold">GymTracker</h1>
        <nav className="space-y-1">
          <NavLink to="/" end className={linkClass}>
            Dashboard
          </NavLink>
          <NavLink to="/workouts" className={linkClass}>
            Workouts
          </NavLink>
          <NavLink to="/exercises" className={linkClass}>
            Exercises
          </NavLink>
          <NavLink to="/sessions" className={linkClass}>
            Sessions
          </NavLink>
        </nav>
      </aside>
      <main className="flex-1 p-6">
        <Outlet />
      </main>
    </div>
  );
}
