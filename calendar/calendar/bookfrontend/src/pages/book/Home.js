import React, { useEffect, useState} from 'react';
import BookItem from '../../components/BookItem';

function Home() {
  const[books, setBooks] = useState([]);

  useEffect(()=>{
    const headers = { 'Content-Type': 'application/json' }
    fetch('http://localhost:8080/book', { headers })
        .then(response => response.json())
        .catch(error => {
          
          console.error('There was an error!', error);
      });
        // .then(data => setBooks({ data}));
  },[])

  // const headers = { 'Content-Type': 'application/json' }
  //   fetch('http://localhost:8080/book', { headers })
  //       .then(response => response.json())
  //       .then(data => setBooks({ data}));

  return (
    <div>
        {books.map(book=> <BookItem key={book.id} book = {book}></BookItem> )}        
    </div>
  );
}

export default Home;
