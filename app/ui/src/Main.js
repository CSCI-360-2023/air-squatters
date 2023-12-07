import React, { useState, useEffect } from 'react';
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { useNavigate } from 'react-router-dom';

function App() {

  const navigate = useNavigate();
  const [searchVal, setSearchVal] = useState('')

    return (
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
            <Button onClick={() => {navigate('/profile')}} color="inherit">Profile</Button>
          </Toolbar>
        </AppBar>
        <div class="center">Search:
            <input type="Text" onChange={event => {setSearchVal(event.target.value)}} placeholder="Search for Events" readonly></input>
            <button onClick={() => {navigate('/results', {replace: true, state:{searchVal}})}}>Search</button>
            <br/>
            <button onClick={() => {navigate('/purchase')}}color="inherit">Buy Now</button>
            <br/>
            <button onClick={() => {navigate('/')}}>Log out</button>
        </div>
      </div>
    );
}
export default App;