import { NavLink, Outlet } from "react-router-dom";
import { Menu, X } from "lucide-react";
import { useState } from "react";

export default function App() {
  const [sidebarOpen, setSidebarOpen] = useState(false);

  const linkClass = ({ isActive }: { isActive: boolean }) =>
    `block px-3 py-2 rounded hover:bg-gray-100 ${isActive ? "bg-gray-200 font-medium" : ""}`;

  const closeSidebar = () => setSidebarOpen(false);

  return (
    <div className="min-h-screen flex">
      {/* Mobile overlay */}
      {sidebarOpen && (
        <div
          className="fixed inset-0 bg-black bg-opacity-50 z-40 lg:hidden"
          onClick={closeSidebar}
        />
      )}

      {/* Sidebar */}
      <aside
        className={`
          fixed lg:static inset-y-0 left-0 z-50
          w-60 border-r bg-white p-4 space-y-4
          transform transition-transform duration-200 ease-in-out
          ${sidebarOpen ? "translate-x-0" : "-translate-x-full lg:translate-x-0"}
        `}
      >
        <div className="flex items-center justify-between">
          <h1 className="text-xl font-semibold">GymTracker</h1>
          <button
            onClick={closeSidebar}
            className="lg:hidden p-1 rounded hover:bg-gray-100"
            aria-label="Close menu"
          >
            <X size={20} />
          </button>
        </div>
        <nav className="space-y-1">
          <NavLink to="/" end className={linkClass} onClick={closeSidebar}>
            Dashboard
          </NavLink>
          <NavLink to="/workouts" className={linkClass} onClick={closeSidebar}>
            Workouts
          </NavLink>
          <NavLink to="/exercises" className={linkClass} onClick={closeSidebar}>
            Exercises
          </NavLink>
          <NavLink to="/sessions" className={linkClass} onClick={closeSidebar}>
            Sessions
          </NavLink>
        </nav>
      </aside>

      {/* Main content */}
      <main className="flex-1 w-full lg:w-auto">
        {/* Mobile header with hamburger */}
        <div className="lg:hidden border-b p-4 bg-white sticky top-0 z-30">
          <button
            onClick={() => setSidebarOpen(true)}
            className="p-2 rounded hover:bg-gray-100"
            aria-label="Open menu"
          >
            <Menu size={24} />
          </button>
        </div>
        
        {/* Page content */}
        <div className="p-4 sm:p-6">
          <Outlet />
        </div>
      </main>
    </div>
  );
}
