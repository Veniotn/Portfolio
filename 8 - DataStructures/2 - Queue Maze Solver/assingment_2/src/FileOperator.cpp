//
// Created by nick on 10/18/2023.
//
#include "FileOperator.h"
using namespace std;

FileOperator::FileOperator(string in_file_name, string out_file_name) {
    //if both file names are valid, create the file objects.
    if (has_valid_name(in_file_name) && has_valid_name(out_file_name)) {
        m_in_file = ifstream(in_file_name);
        m_out_file = ofstream(M_OUTPUT_FILE_BASE_PATH + out_file_name);
    }
}

ifstream &FileOperator::get_in_file() {
    return m_in_file;
}


ofstream &FileOperator::get_out_file() {
    return m_out_file;
}


bool FileOperator::has_valid_name(std::string &file_name_input) {
    //any file name / path that ends in .txt returns true.
    return regex_match(file_name_input, M_FILENAME_REGEX);
}
