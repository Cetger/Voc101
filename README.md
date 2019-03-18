# Voc101
Android Vocabulary Application
Voc101 is a memorizing app with a focus on repeat.
I will develoop Android App, 

[Ofline version(sqlite) of this app.](https://github.com/Cetger/EnglishV101)

**Features**
- [x]  **Login / Sign up**

- [x] **Add a new word** (Only user can see this word. I must avoid spam but also i must give a option for adding new word)

- [ ] **Select a word from Vocabulary List**

*I designed like that program must able to show all list (Top 1000, Top 3000, Top 5000, Jobs, Buildings, Animals etc. A user can see which word in their list and they must be able to select all list by clicking one button)*
 
- [x] **Test**

Test with other words: when users want to check themselves, test fragment will open. They will see all words as a list. This list will order as usign percent of word that means when they start to check, they will see firstly worst word and they will check step by step. 

  **Why?**
  
   *Because when you know a word, program asked you 10 times and you chose 10 times true answer that means you know this word. You shouldnt waste your time with words which you know.*
   
   **Percent Calculation:**
   I decided to count percent of a word
   
   TrueAnswerCount/TotalAnswerCount
   
   But there was a program think it if you select a word and you chose true answer in test that means that this word is %100         
   percent. F.e. if you have a 2000 word in your list, you must answer 1999 questions to see this word.
   
   I mean when a word is one true answer and one total answer, that is equal a word is ten true answer and ten total answer.
   It musnt like that. 
    Therefore i decided to use this equal for percent
    
    TrueAnswer*TrueAnswer/TotalAnswer
  
    

    F.e word1 and word2, word3, 
    word1 is one true anser and one total answer that means 1*1/1=1
    Word2 is two true answer and two total answer that means 2*2/2=2
    Word3 is three true answer and three total answer that means 3*3*/3=3
   
   I think that this method is more useful. Maybe i can change this equation in future. But i am using it for now
  

- [x]  **List**

It is easy to part of program, Users must able to see their all words in a listview. 
