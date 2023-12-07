import React, { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import LogInPage from './LogIn.js';
import SignUpPage from './SignUp.js';
import MainPage from './Main.js';
import ProfilePage from './Profile.js';
import SearchPage from './SearchEvents.js';
import PurchasePage from './PurchaseTickets.js'

const root = createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<LogInPage/>}/>
        <Route path='/signup' element={<SignUpPage/>}/>
        <Route path='/main' element={<MainPage/>}/>
        <Route path='/profile' element={<ProfilePage/>}/>
        <Route path='/results' element={<SearchPage/>}/>
        <Route path='/purchase' element={<PurchasePage/>}/>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);