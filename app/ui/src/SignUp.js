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

function SignUp() {

const navigate = useNavigate();
const [username, setUsername] = useState([])
const [password, setPassword] = useState([])
const [passwordAgain, setPasswordAgain] = useState([])

    return (
      <div class="center">
        <h1>Sign Up</h1>
          <form>
            <label>Username:&emsp;&emsp;&emsp;&nbsp;&nbsp;&nbsp;</label>
            <input type="text" onChange={e => setUsername(e.target.value)} placeholder="Create a Username"></input>
            <br/>
			      <label>Password:&emsp;&emsp;&emsp;&emsp;</label>
			      <input type="password" onChange={e => setPassword(e.target.value)} placeholder="Create a Password"/>
            <br/>
			      <label>Confirm Password:&nbsp;</label>
			      <input type="password" onChange={e => setPasswordAgain(e.target.value)} placeholder="Confirm Your Password"/>
            <br/>
            <br/>
			      <PasswordChecklist
				    rules={["minLength", "lowercase", "capital", "number", "specialChar", "match"]}
				    minLength={15}
				    value={password}
				    valueAgain={passwordAgain}
				    onChange={(isValid) => {}}
			      />
          </form>
          <br/>
          <button onClick={() => {navigate('/')}}>Sign Up Now!</button>
          <br/>
      </div>
    );
}
export default SignUp;

/*<div>
            Password:&nbsp;&nbsp;
            <input type="password" name="Password" placeholder="Create a Password"></input>
          </div>*/