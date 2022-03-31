import './App.css';
import { useState, useEffect } from 'react';
import HomePage from './pages/HomePage';
import GamePage from './pages/GamePage';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";

function App() {

  const [petId, setPetId] = useState(JSON.parse(window.localStorage.getItem('petId')));

  useEffect(() => {
    window.localStorage.setItem('petId', petId);
  }, [petId]);


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
