import './App.css';
import { useState, useEffect } from 'react';
import HomePage from './pages/HomePage';
import GamePage from './pages/GamePage';
import NewPetPage from './pages/GamePage';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";

function App() {

  const [petId, setPetId] = useState(JSON.parse(window.localStorage.getItem('petId'))) || 1;
  const [audioPlaying, setAudioPlaying] = useState(false);

  const toggleAudio = () => {setAudioPlaying(true)};

  useEffect(() => {
    window.localStorage.setItem('petId', petId);
  }, [petId]);


  return (
    <Router>
      <Routes>
        <Route index element={<HomePage setPetId={setPetId}/>}/>
        <Route path="/new" element={<NewPetPage/>}/>
        <Route path="/game" element={<GamePage petId={petId} toggleAudio={toggleAudio} audioPlaying={audioPlaying}/>}/>
      </Routes>
    </Router>
  );
}

export default App;
