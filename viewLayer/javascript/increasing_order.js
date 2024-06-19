// tells you if you remove 1 element, the remaining will still go in increasing order
function solution(sequence) {
    canIncrease = true;
    testCount = 0
    for (var i = 0; i < sequence.length-2; i++) {
        if (sequence[i] >= sequence[i+1]) {
            console.log("10 "+i+"  "+sequence[i]);
            testCount++;
            if (i > 0) {
               console.log("15");
               if (sequence[i] >= sequence[i+2] && sequence[i-1] >= sequence[i+1])  {
                   console.log("20");
                   testCount++;
               } else {
                   console.log("30");
               }
            } else {
                console.log("40");
                //testCount++;
            }
        }
    }
    if (sequence[sequence.length-2] >= sequence[sequence.length-1]) {
        console.log("60");
        testCount++;
    }
    console.log(testCount);
    if (testCount > 1) {
        console.log("90");
        canIncrease = false;
    }
    return canIncrease;
}
