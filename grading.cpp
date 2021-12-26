#include <iostream> 
#include <vector>
#include <algorithm>
#include <iomanip>
#include <string>
#include <cctype>

//working on gradevalidation function. it is not working... short will not take negative number
// so when the input is negative, it will be the max value of short can hold.
// str(10, ' ') is not working. used string(10, ' ') instead with in the cout. 
// g++ -g -Wall -O3 -std=c++11 grading.cpp -o grade && time ./grade

class grade{
    public:
        void menu();
        void getInput();
        void extractLastName();
        void print();
        void getName();
        void mean();
        void medianFun();
        void optionValidation();
        void gradeValidation();
        void checkName();
    private:
        short grade = 0, totalGrade = 0, option = 0;
        double median = 0, average = 0;
        std::vector<unsigned short> grades;
        std::string name;
};

void grade::checkName(){
    unsigned short i = 0;
    while(i < name.length()){
        if(isdigit(name.at(i))){
            std::cout << "Your name has a digit, please re enter a valid name >> : ";
            std::getline(std::cin, name);
            break;
        }
        i++;
    }
}

void grade::extractLastName(){
    unsigned short i = 0;
    checkName();
    if(name.at(0) == ' ')
        name = name.erase(0,1); 
    if(name.back() == ' ')
        name = name.erase(name.length()-1,1);
    for(int i = 0; i < name.length(); i++)
        name.at(i) = tolower(name.at(i));
    while(i < name.length()){
        if(name.at(i) == ','){
            name = name.substr(0,i);
            break;
        }
        if(name.at(i) == ' '){
            name = name.substr(i+1, name.length());
            break;
        }
        i++;
    }
    name.at(0) = toupper(name.at(0));
}

void grade::getName(){
    std::cout << "Enter your name: first last or last, first >> ";
    getline(std::cin, name);
    extractLastName();
}

void grade::getInput(){
    std::cout << "\nProfessor " << name << " please enter the grade >> ";
    std::cin >> grade;
    gradeValidation();
    grades.push_back(grade);
    std::cout << "\nAnymore grade? Yes = 1, No = 0 >> ";
    std::cin >> option;
    optionValidation();
}

void grade::medianFun(){
    std::sort(grades.begin(), grades.end()); 
    unsigned short med = grades.size() / 2;
    if((grades.size() % 2) == 0)
        median = ((double)grades.at(med) + (double)grades.at(med-1)) / 2;
    else
        median = grades.at(med);
}
void grade::mean(){
    for(auto i : grades)
        totalGrade += i;
    average = ((double)totalGrade / (double)grades.size());
}

void grade::print(){
    mean();
    medianFun();
    std::cout << std::fixed << std::setprecision(2);
    std::cout << std::string(30, ' ') << "Statsitics" << std::string(10, ' ') << std::endl;
    std::cout << std::left
              << std::setw(20) << "Class Size"
              << std::setw(20) << "Low"
              << std::setw(20) << "Average" 
              << std::setw(20) << "Median" 
              << std::setw(20) << "High" << std::endl;
    std::cout << std::left
              << std::setw(20) << grades.size()
              << std::setw(20) << grades.at(0) 
              << std::setw(20) << average
              << std::setw(20) << median 
              << std::setw(20) << grades.back() << std::endl;
}

void grade::gradeValidation(){
    while(grade < 0){
        std::cout << "Grade is less than 0, please input a valid grade >> ";
        std::cin >> grade;
        if(grade >= 0)
            break;
    }
}
void grade::optionValidation(){
    int i = 0;
    if(option != 1 and option != 0){
        for(i = 0; i < 3; i++){
            std::cout << "You have " << (3 - i) << 
            " chances left, please enter 1 to add more grade, 0 to exit and view the stat >> ";
            std::cin >> option;
            if(option == 1 or option == 0)
                break;
        }
        if(i == 3)
          std::cout << "Invalid input, program force to quit";
          exit(1);
    }
}

void grade::menu(){
    getName();
    do{
        getInput();
    }while(option);
    print();
    std::cout << "\n";
}

int main(){
    grade gradeObj;
    gradeObj.menu();
    return 0;
}
