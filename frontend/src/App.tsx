import { useState } from 'react';
import './App.css';
import { Pages } from './constants';
import { CreateDoubleGameForm } from './CreateDoubleGameForm';
import { CreatePlayerForm } from './CreatePlayerForm';
import { CreateSingleGameForm } from './CreateSingleGameForm';
import { HeaderComponent } from './Header';


export function App() {
  const [ showPage, setShowPage ] = useState(Pages.HOME)
  return (
    <div>
      <HeaderComponent setShowPage={setShowPage} />
      {showPage === Pages.HOME && <div/> }
      {showPage === Pages.CREATE_PLAYER && <CreatePlayerForm/>}
      {showPage === Pages.CREATE_SINGLE_GAME && <CreateSingleGameForm/> }
      {showPage === Pages.CREATE_DOUBLE_GAME && <CreateDoubleGameForm/> }
    </div>
  );
}