import { useState } from 'react';
import './App.css';
import { CreatePlayerForm } from './CreatePlayerForm';
import { CreateSingleGameForm } from './CreateSingleGameForm';
import { HeaderComponent } from './Header';


export function App() {
  const [ showPage, setShowPage ] = useState('home')
  return (
    <div>
      <HeaderComponent setShowPage={setShowPage} />
      {showPage === 'home' && <div/> }
      {showPage === 'createPlayer' && <CreatePlayerForm/>}
      {showPage === 'createSingleGame' && <CreateSingleGameForm/> }
    </div>
  );
}