package ru.netunix.leetcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.Charset;

@Controller
@Slf4j
public class MainController {
    @Value(value = "classpath:code/242_valid_anagram.txt")
    private Resource validAnagram;
    @Value(value = "classpath:code/88_merge_sorted_arrays.txt")
    private Resource mergeSortedArrays;
    @Value(value = "classpath:code/66_plus_one.txt")
    private Resource plusOne;
    @Value(value = "classpath:code/69_sqrt.txt")
    private Resource sqrtX;
    @Value(value = "classpath:code/83_remove_duplicates_from_sorted_list.txt")
    private Resource rmvDuplicates;
    @Value(value = "classpath:code/169_majority_element.txt")
    private Resource mjrElement;
    @Value(value = "classpath:code/219_contain_duplicates_ii.txt")
    private Resource containsDuplicates2;
    @Value(value = "classpath:code/2469_convert_the_temperature.txt")
    private Resource convertTemperature;
    @Value(value = "classpath:code/1_two_sum.txt")
    private Resource twoSum;
    @Value(value = "classpath:code/2_add_two_numbers.txt")
    private Resource addTwoNumbers;
    @Value(value = "classpath:code/2_longest_substring_without_repeating_characters.txt")
    private Resource longestSubstring;
    @Value(value = "classpath:code/4_median_two_sorted_array.txt")
    private Resource medianTwoSortedArrays;
    @Value(value = "classpath:code/5_longest_palindromic_substring.txt")
    private Resource longestPalindromicSubstring;


    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/validAnagram")
    public String showAnswerValidAnagram(Model model) throws IOException {
        String code = StreamUtils.copyToString(validAnagram.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 01. 242. Valid Anagram";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/mergeSortedArrays")
    public String showAnswerMergeSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(mergeSortedArrays.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 02. 88. Merge Sorted Arrays";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/plusOne")
    public String showAnswerPlusOne(Model model) throws IOException {
        String code = StreamUtils.copyToString(plusOne.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 03. 66. Plus One";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/sqrtX")
    public String showSqrtX(Model model) throws IOException {
        String code = StreamUtils.copyToString(sqrtX.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 04. 69. Sqrt(x)";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/removeDuplicatesSortedList")
    public String showRemoveDuplicates(Model model) throws IOException {
        String code = StreamUtils.copyToString(rmvDuplicates.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 05. 83. Remove Duplicates from Sorted List";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getMajorityElement")
    public String getMajorityElement(Model model) throws IOException {
        String code = StreamUtils.copyToString(mjrElement.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 06. 169. Majority element";
        model.addAttribute("taskName", taskName);
        return "task";

    }

    @GetMapping("/containsDuplicateSecond")
    public String getContainsDuplicateSecond(Model model) throws IOException {
        String code = StreamUtils.copyToString(containsDuplicates2.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 07. 219. Contains Duplicate II";
        model.addAttribute("taskName", taskName);
        return "task";

    }

    @GetMapping("/convertTheTemperature")
    public String getConvertTheTemperature(Model model) throws IOException {
        String code = StreamUtils.copyToString(convertTemperature.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 08. 2469. Convert The Temperature";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    //todo refactoring remove enormous amount of task- html make template with variable
    @GetMapping("/getTwoSumIndexes")
    public String getTwoSumIndexes(Model model) throws IOException {
        String code = StreamUtils.copyToString(twoSum.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 09. 1. Two Sum";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getAddTwoNumbersLinkedList")
    public String getAddTwoNumbersLinkedList(Model model) throws IOException {
        String code = StreamUtils.copyToString(addTwoNumbers.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 10. 2. Add Two Numbers";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getLongestSubstringWithoutRepeatingCharacters")
    public String getLongestSubstring(Model model) throws IOException {
        String code = StreamUtils.copyToString(longestSubstring.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 11. 3. Longest Substring Without Repeating Characters";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    //getMedianTwoSortedArrays
    @GetMapping("/getMedianTwoSortedArrays")
    public String getMedianTwoSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(medianTwoSortedArrays.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 12. 4. Median of Two Sorted Arrays";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getLongestPalindromicSubstring")
    public String getLongestPalindromicSubstring(Model model) throws IOException {
        String code = StreamUtils.copyToString(longestPalindromicSubstring.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 13. 5. Longest Palindromic Substring";
        model.addAttribute("taskName", taskName);

        return "task";
    }
}
