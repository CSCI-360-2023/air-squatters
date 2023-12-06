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
import { googleLogout, useGoogleLogin } from '@react-oauth/google';
import axios from 'axios';
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";

function App() {
    const [ user, setUser ] = useState([]);
    const [ profile, setProfile ] = useState([]);

    const login = useGoogleLogin({
        onSuccess: (codeResponse) => setUser(codeResponse),
        onError: (error) => console.log('Login Failed:', error)
    });

    useEffect(
        () => {
            if (user) {
                axios
                    .get(`https://www.googleapis.com/oauth2/v1/userinfo?access_token=${user.access_token}`, {
                        headers: {
                            Authorization: `Bearer ${user.access_token}`,
                            Accept: 'application/json'
                        }
                    })
                    .then((res) => {
                        setProfile(res.data);
                    })
                    .catch((err) => console.log(err));
            }
        },
        [ user ]
    );

    // log out function to log the user out of google and set the profile array to null
    const logOut = () => {
        googleLogout();
        setProfile(null);
    };

    return (
        <div>
            {profile ? (
              <div>
                <AppBar position="static">
                    <Toolbar>
         
                        <Typography
                            variant="h6"
                            component="div"
                            sx={{ flexGrow: 1 }}
                        >
                            Home
                        </Typography>
                        <Button onClick={() => login()} color="inherit">Profile</Button>
                    </Toolbar>
                </AppBar>
                <div class="center">Search:
                  <input type="Text" placeholder="Search for Events" readonly></input>
                  <button>Search</button>
                  <br/>
                  <button onClick={logOut}>Log out</button>
                </div>
              </div>
            ) : (
                <div class="center">
                <h2>Log In To Ticketing System</h2>
                <button onClick={() => login()}>Sign in with Google</button>
                </div>
            )}
        </div>
    );
}
export default App;