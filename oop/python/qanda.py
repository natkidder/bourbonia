import os
import re
import sys
import numpy as np

def levenshtein_ratio_and_distance(s, t, ratio_calc = True):
    """ levenshtein_ratio_and_distance:
        Calculates levenshtein distance between two strings.
        If ratio_calc = True, the function computes the
        levenshtein distance ratio of similarity between two strings
        For all i and j, distance[i,j] will contain the Levenshtein
        distance between the first i characters of s and the
        first j characters of t
    """
    # Initialize matrix of zeros
    rows = len(s)+1
    cols = len(t)+1
    distance = np.zeros((rows,cols),dtype = int)

    # Populate matrix of zeros with the indeces of each character of both strings
    for i in range(1, rows):
        for k in range(1,cols):
            distance[i][0] = i
            distance[0][k] = k

    # Iterate over the matrix to compute the cost of deletions,insertions and/or substitutions    
    for col in range(1, cols):
        for row in range(1, rows):
            if s[row-1] == t[col-1]:
                cost = 0 # If the characters are the same in the two strings in a given position [i,j] then the cost is 0
            else:
                # In order to align the results with those of the Python Levenshtein package, if we choose to calculate the ratio
                # the cost of a substitution is 2. If we calculate just distance, then the cost of a substitution is 1.
                if ratio_calc == True:
                    cost = 2
                else:
                    cost = 1
            distance[row][col] = min(distance[row-1][col] + 1,      # Cost of deletions
                                 distance[row][col-1] + 1,          # Cost of insertions
                                 distance[row-1][col-1] + cost)     # Cost of substitutions
    if ratio_calc == True:
        # Computation of the Levenshtein Distance Ratio
        Ratio = ((len(s)+len(t)) - distance[row][col]) / (len(s)+len(t))
        return Ratio
    else:
        # print(distance) # Uncomment if you want to see the matrix showing how the algorithm computes the cost of deletions,
        # insertions and/or substitutions
        # This is the minimum number of edits needed to convert string a to string b
        return "The strings are {} edits away".format(distance[row][col])

def question_cnt(file_to_open,start_question_nbr):
    cnt = 0
    f = open(file_to_open, 'r')
    q_pattern = re.compile("^q=.*$")
    for line in open(file_to_open, 'r').readlines():
        if q_pattern.match(line):
            cnt += 1
    return cnt - start_question_nbr
    
def has_blank_last_line(file_to_open):
    f = open(file_to_open, 'r')
    last_line = f.readlines()[-1].rstrip('\n')
    print ("last_line is '" + last_line + "'") ####
    whitespace_pattern = re.compile("^\\s*$")
    has_blank_last_line = False
    if whitespace_pattern.match(last_line):
        has_blank_last_line = True
    return has_blank_last_line

def set_need_2nd_penalty():
    need_2nd_penalty = input("\nWhat percentage penalty should there be for needing a hint (0-100, default 20)? ")
    if (need_2nd_penalty.__eq__('')):
        need_2nd_penalty = '20'
    need_2nd_penalty = int(need_2nd_penalty)
    if (need_2nd_penalty < 0 or need_2nd_penalty > 100):
        print("Invalid entry, will set to 10")
        need_2nd_penalty = 10
    return need_2nd_penalty
    
def append_wrong_file(wrong_cnt, wat_out, question, true_answers):
    wat_out.write("\nq=" + question + "\n")
    for true_answer in true_answers:
        wat_out.write("a=" + true_answer + "\n")

def transform_question(question, delimiter, is_displaying):
    if not is_displaying and delimiter in question:
        question = question.split(delimiter)[0]
    return question
    
def process_answer(question, true_answers, all_cnt, need_2nd_penalty):
    how_correct = 0
    close_enough = 0.9
    times_repeat = 0
    fully_correct_accolade = "Correct!"
    if len(true_answers) < 2:
        true_answer_prefix = "The correct answer is: "
    else:
        true_answer_prefix = "A correct answer is: "
    while times_repeat < 2:
        if times_repeat < 1:
            response = input("\n" + str(all_cnt) + ".  " + transform_question(question, " - ", False) + ":  ")
        else:
            response = input("\n" + str(all_cnt) + ".  " + question + ":  ")
        response = response.lower().replace(", ",",").replace("-"," ")
        ### got the exact answer, as it's in the array
        if len(list(filter (lambda x : x == response, true_answers))) > 0:
            print(fully_correct_accolade)
#            how_correct = 1
            how_correct = 1 - (times_repeat * (need_2nd_penalty/100))
            #print("completely correct grade: "+str(how_correct)) ######
            times_repeat = 2
        else:
            for true_answer in true_answers:
                orig_true_answer = true_answer
                true_answer = true_answer.lower().replace(", ",",").replace("-"," ")
                if len(response) < 1:  ## user just tapped Enter
                    how_correct = 0
                    break
                else:
                    #print(true_answer) #######
                    answer_closeness = float(levenshtein_ratio_and_distance(true_answer, response))
                    #print("response = '"+response+"'    true_answer = '"+true_answer+"'    answer_closeness="+str(answer_closeness)) ####
                    if (answer_closeness == 1):
                        print(fully_correct_accolade)
                        how_correct = 1 - (times_repeat * (need_2nd_penalty/100))
                        #print("2nd chance completely correct grade: "+str(how_correct)) ######
                        times_repeat = 2
                        break
                    elif answer_closeness > 0.9: ## if the response is close to the right answer
                        print("Close, answer is: " + orig_true_answer)
                        how_correct = 0.75 - (times_repeat * (need_2nd_penalty/100))
                        times_repeat = 2
                        break
        #print("010: how_correct="+str(how_correct)) ########
        if how_correct < 0.1 and times_repeat < 1:
            print("Try again")
        times_repeat += 1
    if how_correct < 0.1:
        print(true_answer_prefix + orig_true_answer)
    #print("020: how_correct="+str(how_correct)) ########
    return how_correct
    
def main():
    ## ASSUMES the Q&A is in the following format:
    ## q=day is the opposite of ___ - N
    ## a=night
    ## a=evening
    ## <blank line>
    ## you can have as many possible ansers as you want, and clues cna be in any format your want,
    ## so long as a " - " separates the clue from the question
    ## the answer is first evaluated against the question for exactness, then "close enough", then is judged wrong 
    if len(sys.argv) < 1:
        print("arg1: file to read")
        sys.exit(1)
    file_to_open = sys.argv[1]
    if not has_blank_last_line(file_to_open):
        print("file " + file_to_open + " needs a blank last line")
        sys.exit(2)
    chances_allowed = 2
    ## if previously you had to stop in the middle and want to pick up where you left off
    start_question_nbr = input("\nAt what question number do you wish to start (default 1): ")
    if start_question_nbr == "":
        start_question_nbr = 0
    else:
        start_question_nbr = int(start_question_nbr)
    print("\n"+str(question_cnt(file_to_open,start_question_nbr))+" questions to answer")
    wrong_answers_to = file_to_open.replace('.txt', '_wrong.txt')
    ## if you want to send missed questions to the wrong answers file, and if you do, overwrite it or append to it?
    write_to_wrong_file_threshold = 0.01
    is_deleting_file = False
    write_mode = 'w'
    is_appending = input("\nDo you want to (a)ppend, (o)verwrite or (n)ot have the wrong answers file? (default n): ")
    if is_appending.lower() == "o":
        write_mde = 'w'
    elif is_appending.lower() == 'a':
        write_mode = 'a'
    else:
        is_deleting_file = True
    wat_out = open(wrong_answers_to, write_mode)
    if not is_deleting_file:
        near_correct_written = input("\nIf an answer is <100% correct on the first try, do you want it written to the wrong answers file (y/n, default n): ")
        if near_correct_written.lower() == 'y':
            write_to_wrong_file_threshold = 0.99
    need_2nd_penalty = set_need_2nd_penalty()
    close_enough = "0.9"
    close_enough = float(close_enough)
    total_cnt = 0
    all_cnt = 0
    all_attempted = 0
    wrong_cnt = 0
    qa_pattern = re.compile("^[qa]=.*$") ## a question or answer
    q_pattern = re.compile("^q=.*$") ## question only
    cmt_pattern = re.compile("^\\s*#.*$") ## comment
    display_only_pattern = re.compile("^==.*$") ## just display the line
    whitespace_pattern = re.compile("^\\s*$") ## empty line or just whitespace
    question = ""
    print("\nIf there are multiple answers, separate them with commas\n")
    
    ## loop through the Q&A file
    for line in open(file_to_open, 'r').readlines():
        #print(line) #######
        if cmt_pattern.match(line):
            question=""
            continue
        elif display_only_pattern.match(line):
            print("\n" + line)
            question=""
            continue
        ## read through only those lines that are an actual question or answer
        if qa_pattern.match(line):
            #print("question: " + line) #######
            line = line.replace('\n','').replace('\r','').strip() #### remove line break & leading/trailing spaces
            parts = line.split('=')
            if q_pattern.match(line):
                question = parts[1]
                true_answers = []
            else:
                true_answers.append(parts[1])
        elif len(question) > 0:
            all_cnt += 1
            if all_cnt >= start_question_nbr:
                all_attempted += 1
                how_correct = process_answer(question, true_answers, all_cnt, need_2nd_penalty)
                wrong_cnt = wrong_cnt + (1 - how_correct)
                if how_correct < write_to_wrong_file_threshold:
                    #print("how_correct: "+str(how_correct)+"   write_to_wrong_file_threshold:"+str(write_to_wrong_file_threshold)) ########  
                    append_wrong_file(wrong_cnt, wat_out, question, true_answers)
        prev_line = line
    wat_out.write("\n") ## need a blank line at the endswith
    wat_out.close()
    
    if wrong_cnt > 0:
        correct_cnt = all_cnt - wrong_cnt
        proportion_correct = float(correct_cnt) / float(all_cnt)
        print("You got " + str(round(correct_cnt, 1)) + " out of " + str(all_cnt) + ", " + f"{proportion_correct:.0%}")
    else:
        os.remove(wrong_answers_to)
        print("Congratulations, you got 100% correct!")
    if os.path.exists(wrong_answers_to):
        if is_deleting_file or os.path.getsize(wrong_answers_to) < 10:  # if you chose to not write, or nothing material was written
            os.remove(wrong_answers_to)
        else:
            print("Questions missed written to " + wrong_answers_to)

main()
        
