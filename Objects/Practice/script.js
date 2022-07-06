//a plane containing point objects
let plane = {
    name: "cartesian plane",
    origin: {
        x: 0,
        y: 0
    },
    points: [
        { x: 2, y: 4 },
        { x: 1, y: 1 },
        { x: -3, y: 2 },
        { x: 0, y: 1 }
    ],
    onAnAxis: function(x, y) {
        return x === 0 || y === 0;
    },
    distance: function(point1, point2) {
        return Math.sqrt(
            (point1.x - point2.x) ** 2 +
            (point1.y - point2.y) ** 2);
    }
}

// print out the name of the plane
console.log(plane.name);

// print out the origin points in (a, b) format
console.log("(" + plane.origin.x + ", " + plane.origin.y +")");

// print out all the points in (a, b) format
for (let i = 0; i < plane.points.length; i++) {
    let point = plane.points[i];
    console.log("(" + point.x + ", " + point.y +")");
}

// print out the distance between these points
let point1 = {
    x: 3,
    y: 2
}
let point2 = {
    x: 13,
    y: 4
}
let dist = plane.distance(point1, point2);
console.log("Distance: " + dist);