import React, { useState, useEffect } from 'react';
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

function Profile() {

  const navigate = useNavigate();

    return (
      <div class="center">
        <AppBar position="static">
          <Toolbar>
            <Typography
            variant="h6"
            component="div"
            sx={{ flexGrow: 1 }}
            >
              Profile
            </Typography>
            <Button onClick={() => {navigate('/main')}}color="inherit">Go Back</Button>
          </Toolbar>
        </AppBar>
        <h1>Your Events</h1>
      </div>
    );
}
export default Profile;