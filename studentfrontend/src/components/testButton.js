export default function button() {
    const handleClick=(e)=>{
        e.preventDefault()
        //const student={name, address}
        //console.log(student)
        fetch("http://localhost:8080/student/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify("joe", "123 sesame st")
        }).then(()=>{
            console.log("New Student added")
        })
    }
}