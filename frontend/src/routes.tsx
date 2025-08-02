import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import Dashboard from "./pages/Dashboard";
import Exercises from "./pages/Exercises";
import Sessions from "./pages/Sessions";
import Workouts from "./pages/Workouts";

export const routes = createBrowserRouter([
  { path: "/", element: <App />, children: [
    { index: true, element: <Dashboard /> },
    { path: "exercises", element: <Exercises /> },
    { path: "sessions", element: <Sessions /> },
    { path: "workouts", element: <Workouts /> },
  ]}
]);
