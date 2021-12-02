import React, { useEffect, useState } from 'react';
 
function Detail(props) {

const id= props.match.params.id;

const [guidance, setGuidance] = useState({
  guid:"",
  posterName:"",
  guidanceDesc:""
});


useEffect(()=>{ 
  fetch("http://localhost:8080/guidances/" + id, {method:"GET"})
  .then(res =>res.json())
  .then(res=>{
    setGuidance(res)});
},[])

  return (
    <div>
        <h1> MESSAGE FROM MANAGEMENT: </h1>
        <hr/>
        <h3>{guidance.guidanceDesc}</h3>
        <h1>{guidance.posterName}</h1>
    </div>
  );
}

export default Detail;
