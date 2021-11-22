//Move these over

import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { propTypes } from 'react-bootstrap/esm/Image';
function EditForm(props) {
  const[book, setBook] = useState({
    title:'',
    author:'',
  });
 
  const changeValue=(e)=>{
    setBook({
     ...book, [e.target.name]:e.target.value  
    });
  }
 
  const submitBook =(e)=>{
    e.preventDefault();
    fetch("http://localhost:8080/book", {
      method:"POST",
      headers:{
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(book)
    })
    .then(res=>{
        console.log(1,res);
        if(res.status === 201){
          return res.json();
        }else{
          return null;
        }
      })
    .then(res=>{
      console.log(res)
      if(res!==null){
        props.history.push('/');
      }else{
        alert('fails');
      }
    
    });
 
  }
 
  return (
    <div>
<Form onSubmit = {submitBook}>
  <Form.Group controlId="formBasicEmail">
    <Form.Label>Name Of Employee</Form.Label>
    <Form.Control type="text" placeholder="Enter Name" onChange = {changeValue} name="title" />
  </Form.Group>
 
  <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
    <Form.Label>Covid Guidance (1000 Character Limit)</Form.Label>
    <Form.Control as="textarea" rows={4} />
  </Form.Group>
 
  <Button variant="primary" type="submit">
    Submit  
  </Button>
</Form>
    </div>
  );
}
 
export default EditForm;