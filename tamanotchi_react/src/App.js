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

  const [currentPet, setCurrentPet] = useState(1);

  return (
    <Router>
      <Routes>
        <Route index element={<HomePage/>}/>
        <Route path="/game" element={<GamePage currentPet={currentPet}/>}/>
      </Routes>
    </Router>
  );
}

export default App;
