import React from 'react';
import {Card} from 'react-bootstrap';
import { Link } from 'react-router-dom';
 
function BookItem(props) {

  const {id, title, author} = props.book;
  return (
    <Card>
        <Card.Body>
            <Card.Title> {title} </Card.Title>
            <Link to ={"/book/" + id} className="btn btn-primary" variant="primary">
                    View
            </Link> 
        </Card.Body>
    </Card>
  );
}

export default BookItem;
