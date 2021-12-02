import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';
import { propTypes } from 'react-bootstrap/esm/Image';
function EditForm(props) {
  const[guidance, setGuidance] = useState({
    PosterName:'',
    GuidanceDesc:'',
  });

  const changeValue=(e)=>{
    setGuidance({
     ...guidance, [e.target.name]:e.target.value  
    });
    console.log("name "+ e.target.name );
    console.log("value "+ e.target.value );

  }

  const submitGuidance =(e)=>{
    e.preventDefault();
    fetch("http://localhost:8080/guidances", {
      method:"POST",
      headers:{
        "Content-Type" : "application/json"
      },
      body: JSON.stringify(guidance)
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
        alert('Too many characters!\nPlease shorten your description and/or title.\nYou may only use 255 characters for each');
      }
    
    });

  }

  return (
    <div>
<Form onSubmit = {submitGuidance}>
  <Form.Group controlId="formBasicEmail">
    <Form.Label>title</Form.Label>
    <Form.Control type="text" placeholder="Enter Name" onChange = {changeValue} name="posterName" />
  </Form.Group>

  <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
    <Form.Label>Covid Guidance (255 Character Limit)</Form.Label>
    <Form.Control as="textarea" placeholder="Enter desc" onChange = {changeValue} name="guidanceDesc" rows={4} />
  </Form.Group>

  <Button variant="primary" type="submit">
    Submit  
  </Button>
</Form>
    </div>
  );
}

export default EditForm;
