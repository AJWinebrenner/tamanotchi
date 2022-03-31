import './App.css';
import { useState } from 'react';
import HomePage from './pages/HomePage';
import GamePage from './pages/GamePage';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";

function App() {

  const [petId, setPetId] = useState(0);


  return (
    <Router>
      <Routes>
        <Route index element={<HomePage setPetId={setPetId}/>}/>
        <Route path="/game" element={<GamePage petId={petId}/>}/>
      </Routes>
    </Router>
  );
}

export default App;
