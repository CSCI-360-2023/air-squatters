/*import './App.css';
import * as React from "react";
 
// importing material UI components
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import { GoogleLogin } from '@react-oauth/google';
import Main from "./pages/Main";
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
function App() {
  const responseMessage = (response) => {
    console.log(response);
  };
const errorMessage = (error) => {
    console.log(error);
  };
*/

import React, { useState, useEffect } from 'react';
import PasswordChecklist from "react-password-checklist"
import { googleLogout, useGoogleLogin } from '@react-oauth/google';
import axios from 'axios';
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import {Routes, Route, useNavigate} from 'react-router-dom';

function App() {

const [username, setUsername] = useState([])
const [password, setPassword] = useState([])
const [passwordAgain, setPasswordAgain] = useState([])

  return (
    <div class="center">
        <h1>Checkout</h1>
      <br/>
      <form> 
        <label>Credit Card Number:&nbsp;</label>
        <input type="number" minLength={16} maxLength={16} placeholder="Enter Credit Card Number"/>
        <br/>
        <label>Expiration Date:&emsp;&emsp;&nbsp;&nbsp;</label>
        <input type="text" placeholder="mm/yy"/>
        <label>CVV/CVC:&emsp;&emsp;&emsp;&emsp;&emsp;</label>
        <input type="text" placeholder="123"/>
        <br/>
        <label>Name On Card:&emsp;&emsp;&nbsp;&nbsp;</label>
        <input type="text" placeholder="John Doe"/>
        <br/>
        <label>Billing Address:&emsp;&emsp;&nbsp;&nbsp;</label>
        <input type="text" placeholder="123 Place St"/>
        <br/>
        <label>City:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;</label>
        <input type="text" placeholder="Cityville"/>
        <br/>
        <label>State:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;</label>
        <input type="text" placeholder="SC"/>
        <br/>
        <label>Zip Code:&emsp;&emsp;&emsp;&emsp;&emsp;</label>
        <input type="number" placeholder="12345"/>
        <br/>
        <button>Checkout</button>
      </form>
    </div>
    );
}
export default App;