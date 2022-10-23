import { useState } from 'react';
import './App.css';
import { Pages } from './constants';
import { CreateDoubleGameForm } from './modules/createDoubleGame/CreateDoubleGameForm';
import { CreatePlayerForm } from './modules/createPlayer/CreatePlayerForm';
import { CreateSingleGameForm } from './modules/createSingleGame/CreateSingleGameForm';
import { HeaderComponent } from './Header';
import { HelpPage } from './modules/description/HelpPage';
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css'; // Necessary for getting correct Toasts


export function App() {
  const [ showPage, setShowPage ] = useState(Pages.HOME)
  return (
    <div>
      <HeaderComponent setShowPage={setShowPage} />
      <ToastContainer /> {/* Necessary for showing toasts */}
      {showPage === Pages.HOME && <div/> }
      {showPage === Pages.CREATE_PLAYER && <CreatePlayerForm/>}
      {showPage === Pages.CREATE_SINGLE_GAME && <CreateSingleGameForm/> }
      {showPage === Pages.CREATE_DOUBLE_GAME && <CreateDoubleGameForm/> }
      {showPage === Pages.HELP_FAQ && <HelpPage/> }  
    </div>
  );
}