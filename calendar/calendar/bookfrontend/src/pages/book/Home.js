import React, { useEffect, useState} from 'react';
import BookItem from '../../components/BookItem';
 
function Home() {
<div>
  Welcome

</div>
  const[guidances, setGuidance] = useState([]);

  useEffect(()=>{
      fetch("http://localhost:8080/guidances", {method:"GET"})
      .then(res => res.json())
      .then(res=> {setGuidance(res);
      
      console.log(res);
      })
  },[])

  console.log(guidances)
  if(guidances.length == 0) { //No guidances
    return (
        <div>
            <h2>There is no new guidance posted.</h2>
            <p>Check back here later to see if management has posted anything.</p>
        </div>
    );
  }
  else {
      return (
        <div>
            <h2>Guidance from management:</h2>
            {guidances.map(guidance=> <BookItem key={guidance.guid} guidance = {guidance}></BookItem> )}
        </div>
      );
  }
}

export default Home;
