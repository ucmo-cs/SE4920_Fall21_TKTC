import React from 'react';
import {Card, Modal, Button, Form} from 'react-bootstrap';
import { Link } from 'react-router-dom';
 
function SignUpModals({show, onHide}) {
 
  return (
    <Modal
      show= {show}
      onHide = {onHide}
      size="lg"
      aria-labelledby="contained-modal-title-vcenter"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
          Modal heading
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
      
      <Form> 
  
  <Form.Group controlId="formBasicEmail">
    <Form.Label>Name</Form.Label>
    <Form.Control placeholder="Enter your name" />
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>Email Address</Form.Label>
    <Form.Control type="email" placeholder="Enter your email" />
  </Form.Group>

  <Form.Group controlId="formBasicEmail">
    <Form.Label>Password</Form.Label>
    <Form.Control type="password" placeholder="Password" />
  </Form.Group>

  <Form.Group className="mb-3" controlId="formBasicPassword">
    <Form.Label>Confirm password</Form.Label>
    <Form.Control type="password" placeholder="Confirm Password" />
  </Form.Group>

</Form>
      </Modal.Body>
      <Modal.Footer>
       <Button type = "button">Submit</Button>
        <Button onClick={onHide}>Close</Button>
      </Modal.Footer>
    </Modal>
  )
}

export default SignUpModals;