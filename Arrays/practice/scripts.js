

// build an array
let numbersArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let fish = ["shark", "swordfish", "cat fish"];

let mixed = [3030, "21st street se", "Seattle", "Wa", 98092, true];
let phoneNumber = new Array("253", "273", "6181");

console.log(fish);
console.log(numbersArray);
console.log(mixed);

console.log("Length of mixed: "+ mixed.length);
console.log(typeof mixed[0]);
console.log(typeof mixed[1]);
console.log(typeof mixed[2]);
console.log(typeof mixed[3]);
console.log(typeof mixed[4]);
console.log(typeof mixed[5]);


// how can we loop over an array
for(let i = 0; i < numbersArray.length; i++) {
    console.log(numbersArray[i]);
}

// print out the average for all numbers in the Array
let sum = 0;
for(let i = 0; i < numbersArray.length; i++) {
    let num = numbersArray[i];
    sum += num;
}
let average = sum / numbersArray.length;
console.log(average);

// most languages use a for each loop
numbersArray.forEach(function(element) {
    console.log(Math.sqrt(element));
});

let classroom = {
  title: "Web Design wotj JS",
  seats: 24,
  projectAvailable: false,
  students: ["Bruce", "Matilda", "Melanie", "Brandon"],
  teacher: {
      first: "Cesar",
      last: "Escalona"
  },

  location: {
      city: "Auburn",
      state: "Wa"
  },

  // method
  enrollStudent: function(studentName) {
      this.students.push(studentName);

      // this method calling another
      this.printStudents();
  },

    // loop through student array method and print out names
  printStudents: function() {
      for(let i = 0; i < this.students.length; i++) {
          console.log(this.students[i]);
      }
  }

};
console.log(typeof classroom.seats);
console.log(typeof classroom.projectAvailable);
console.log(typeof classroom.title);
console.log(typeof classroom);
console.log(typeof classroom.students);

console.log(classroom);

console.log(classroom.teacher.first);
console.log(classroom.location.city);
classroom.enrollStudent("Cesar");

// classroom.printStudents();