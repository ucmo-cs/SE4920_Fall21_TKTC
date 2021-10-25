import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import {Container, Paper, Button} from '@material-ui/core';

export default function User() {

const[name, setName]=React.useState('');
const[address,setAddress]=React.useState('');

const handleClick=(e)=>{
    e.preventDefault()
    const newUser=(name,address)    
    console.log(name)
    fetch("http://localhost:8080/student/add",{
        method:"POST",
        body:JSON.stringify(newUser)
    }).then(()=>{
        console.log("User added")
    })
/*
fetch("http://localhost:8082/auth/realms/mine/protocol/openid-connect/token", {
    method: "POST",
    body: JSON.stringify(formData)
})
*/
}

  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Name" variant="outlined" fullwidth
      value={name}
      onChange={(e)=>setName(e.target.value)}/>
      <Button variant="contained" color="secondary" onClick={handleClick}>
          Button
      </Button>
      <TextField id="outlined-basic" label="Address" variant="outlined" fullwidth
      value={address}
      onChange={(e)=>setAddress(e.target.value)}/>
    </Box>
  );
}
