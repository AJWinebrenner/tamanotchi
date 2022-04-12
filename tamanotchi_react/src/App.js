import { useEffect, useState } from 'react';
import {
  BrowserRouter as Router, Route, Routes
} from "react-router-dom";
import './App.css';
import GamePage from './pages/GamePage';
import HomePage from './pages/HomePage';
import NewPetPage from './pages/NewPetPage';

function App() {

  const [petId, setPetId] = useState(JSON.parse(window.sessionStorage.getItem('petId'))) || 1;
  const [audioPlaying, setAudioPlaying] = useState(false);

  const toggleAudio = () => {setAudioPlaying(true)};

  useEffect(() => {
    window.sessionStorage.setItem('petId', petId);
  }, [petId]);


  return (
    <Router>
      <Routes>
        <Route index element={<HomePage setPetId={setPetId}/>}/>
        <Route path="/new" element={<NewPetPage setPetId={setPetId}/>}/>
        <Route path="/game" element={<GamePage petId={petId} toggleAudio={toggleAudio} audioPlaying={audioPlaying}/>}/>
      </Routes>
    </Router>
  );
}

export default App;
