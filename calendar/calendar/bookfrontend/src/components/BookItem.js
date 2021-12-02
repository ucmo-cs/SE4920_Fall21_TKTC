import React from 'react';
import {Card} from 'react-bootstrap';
import { Link } from 'react-router-dom';
 
function BookItem(props) {

  const {guid, posterName, guidanceDesc} = props.guidance;

  return (
    <Card>
        <Card.Body>
            <Card.Title> <u>{posterName} : </u> <br></br><br></br>{guidanceDesc}</Card.Title>
            <Link to ={"/guidances/" + guid} className="btn btn-primary" variant="primary">
                    View guidance
            </Link>
        </Card.Body>
    </Card>
  );
}

export default BookItem;
