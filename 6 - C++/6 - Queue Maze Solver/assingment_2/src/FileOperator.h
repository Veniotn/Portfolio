//
// Created by nick on 10/18/2023.
//
#ifndef ASSIGNMENT_2_FILEOPERATOR_H
#define ASSIGNMENT_2_FILEOPERATOR_H
#include <iostream>
#include <fstream>
#include <regex>


class FileOperator {

private:
    //regex pattern for valid .txt file.
    const std::regex M_FILENAME_REGEX = std::regex(R"(^(?:.*[\\/:])?[^\\/:*?"<>|]+\.txt$)");
    //path used for creating our output file, append to the front of the desired output file name.
    const std::string M_OUTPUT_FILE_BASE_PATH = "../solved/";

    //input maze file.
    std::ifstream m_in_file;
    //print maze to this file after maze has been solved.
    std::ofstream m_out_file;

    //uses the regex to make sure the file name is a valid txt file.
    bool has_valid_name(std::string &file_name_input);

public:
    //create file operator object using valid file name.
    FileOperator(std::string in_file_name, std::string out_file_name);

    //getters for file objects.
    std::ifstream &get_in_file();
    std::ofstream &get_out_file();

};

#endif //ASSIGNMENT_2_FILEOPERATOR_H
