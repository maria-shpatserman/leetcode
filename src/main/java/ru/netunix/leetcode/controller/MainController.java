package ru.netunix.leetcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import ru.netunix.leetcode.config.Config;

import java.io.IOException;
import java.nio.charset.Charset;

@Controller
@Slf4j
public class MainController {
    private Config configuration;
    @Autowired
    MainController(Config configuration){
        this.configuration = configuration;
    }



    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/validAnagram")
    public String showAnswerValidAnagram(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getValidAnagram().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 01. 242. Valid Anagram";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/mergeSortedArrays")
    public String showAnswerMergeSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMergeSortedArrays().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 02. 88. Merge Sorted Arrays";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/plusOne")
    public String showAnswerPlusOne(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getPlusOne().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 03. 66. Plus One";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/sqrtX")
    public String showSqrtX(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSqrtX().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 04. 69. Sqrt(x)";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/removeDuplicatesSortedList")
    public String showRemoveDuplicates(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getRmvDuplicates().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 05. 83. Remove Duplicates from Sorted List";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getMajorityElement")
    public String getMajorityElement(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMjrElement().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 06. 169. Majority element";
        model.addAttribute("taskName", taskName);
        return "task";

    }

    @GetMapping("/containsDuplicateSecond")
    public String getContainsDuplicateSecond(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getContainsDuplicates2().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 07. 219. Contains Duplicate II";
        model.addAttribute("taskName", taskName);
        return "task";

    }

    @GetMapping("/convertTheTemperature")
    public String getConvertTheTemperature(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getConvertTemperature().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 08. 2469. Convert The Temperature";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    //todo refactoring remove enormous amount of task- html make template with variable
    @GetMapping("/getTwoSumIndexes")
    public String getTwoSumIndexes(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getTwoSum().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 09. 1. Two Sum";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getAddTwoNumbersLinkedList")
    public String getAddTwoNumbersLinkedList(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getAddTwoNumbers().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 10. 2. Add Two Numbers";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getLongestSubstringWithoutRepeatingCharacters")
    public String getLongestSubstring(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLongestSubstring().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 11. 3. Longest Substring Without Repeating Characters";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    //getMedianTwoSortedArrays
    @GetMapping("/getMedianTwoSortedArrays")
    public String getMedianTwoSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMedianTwoSortedArrays().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 12. 4. Median of Two Sorted Arrays";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getLongestPalindromicSubstring")
    public String getLongestPalindromicSubstring(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLongestPalindromicSubstring().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 13. 5. Longest Palindromic Substring";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getAreaWithMostWater")
    public String getAreaWithMostWater(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMostWaterContainer().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 14. 11. Container With Most Water";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getZigZagConversion")
    public String getZigZagConversion(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getZigzagConversion().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 15. 6. ZigZag Conversion";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getReverseInteger")
    public String getReverseInteger(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getReverseInteger().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 16. 7. Reverse Integer";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getStringToIntegerAtoi")
    public String getStringToIntegerAtoi(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getStringToIntegerAtoi().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 17. 8. String to Integer (atoi)";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getLetterCombinations")
    public String getLetterCombinations(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLetterCombinations().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 18. 17. Letter Combinations of a Phone Number";
        model.addAttribute("taskName", taskName);

        return "task";
    }

}
