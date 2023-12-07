import React, { useState, useEffect } from 'react';
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import { useNavigate } from "react-router-dom";

function SearchEvents() {

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
              Search Events
            </Typography>
            <Button onClick={() => {navigate(-1)}}color="inherit">Go Back</Button>
          </Toolbar>
        </AppBar>
        <h1>Results</h1>
        <button onClick={() => {navigate('/purchase')}}color="inherit">Buy Now</button>
      </div>
    );
}
export default SearchEvents;