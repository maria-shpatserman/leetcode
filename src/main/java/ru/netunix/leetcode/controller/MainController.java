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
        String taskName = "Task 242. Valid Anagram";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/mergeSortedArrays")
    public String showAnswerMergeSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMergeSortedArrays().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 88. Merge Sorted Arrays";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/plusOne")
    public String showAnswerPlusOne(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getPlusOne().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 66. Plus One";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/sqrtX")
    public String showSqrtX(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSqrtX().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 69. Sqrt(x)";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/removeDuplicatesSortedList")
    public String showRemoveDuplicates(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getRmvDuplicates().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 83. Remove Duplicates from Sorted List";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getMajorityElement")
    public String getMajorityElement(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMjrElement().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 169. Majority element";
        model.addAttribute("taskName", taskName);
        return "task";

    }

    @GetMapping("/containsDuplicateSecond")
    public String getContainsDuplicateSecond(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getContainsDuplicates2().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 219. Contains Duplicate II";
        model.addAttribute("taskName", taskName);
        return "task";

    }

    @GetMapping("/convertTheTemperature")
    public String getConvertTheTemperature(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getConvertTemperature().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 2469. Convert The Temperature";
        model.addAttribute("taskName", taskName);
        return "task";
    }


    @GetMapping("/getTwoSumIndexes")
    public String getTwoSumIndexes(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getTwoSum().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 1. Two Sum";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getAddTwoNumbersLinkedList")
    public String getAddTwoNumbersLinkedList(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getAddTwoNumbers().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        String taskName = "Task 2. Add Two Numbers";
        model.addAttribute("taskName", taskName);
        return "task";
    }

    @GetMapping("/getLongestSubstringWithoutRepeatingCharacters")
    public String getLongestSubstring(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLongestSubstring().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 3. Longest Substring Without Repeating Characters";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    //getMedianTwoSortedArrays
    @GetMapping("/getMedianTwoSortedArrays")
    public String getMedianTwoSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMedianTwoSortedArrays().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 4. Median of Two Sorted Arrays";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getLongestPalindromicSubstring")
    public String getLongestPalindromicSubstring(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLongestPalindromicSubstring().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 5. Longest Palindromic Substring";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getAreaWithMostWater")
    public String getAreaWithMostWater(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMostWaterContainer().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 11. Container With Most Water";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getZigZagConversion")
    public String getZigZagConversion(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getZigzagConversion().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 6. ZigZag Conversion";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getReverseInteger")
    public String getReverseInteger(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getReverseInteger().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 7. Reverse Integer";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getStringToIntegerAtoi")
    public String getStringToIntegerAtoi(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getStringToIntegerAtoi().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 8. String to Integer (atoi)";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getLetterCombinations")
    public String getLetterCombinations(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLetterCombinations().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 17. Letter Combinations of a Phone Number";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/get3Sum")
    public String get3Sum(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getThreeSum().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 15. 3 Sum";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/get4Sum")
    public String get4Sum(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getFourSum().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 18. 4 Sum";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/get3SumClosest")
    public String get3SumClosest(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getThreeSumClosest().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 16. 3 Sum Closest";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getRemoveNthElement")
    public String getRemoveNthElement(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getRemoveNthElement().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 19. Remove Nth Node from The End of The List";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/generateParentheses")
    public String generateParentheses(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getGenerateParentheses().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 22. Generate Parentheses";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getMergedKSortedLists")
    public String getMergedKSortedLists(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMergeKSortedLists().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 23. Merge k Sorted Lists";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getSwappedNodesInPairs")
    public String getSwappedNodesInPairs(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSwappedNodesInPairs().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 24. Swap Nodes In Pairs";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getReversedNodesInGroups")
    public String getReversedNodeListInGroups(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getReversedNodesInGroups().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 25. Reverse Nodes In k-Group";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getConcatenationAllWords")
    public String getConcatenationAllWords(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getConcatenationAllWords().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 30. Substring with Concatenation of All Words ";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getIsValidSudoku")
    public String getIsValidSudoku(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getIsValidSudoku().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 36. Valid Sudoku ";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getSudokuSolver")
    public String getSudokuSolver(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSudokuSolver().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 37. Sudoku Solver";
        model.addAttribute("taskName", taskName);

        return "task";
    }

    @GetMapping("/getFirstMissingPositive")
    public String getFirstMissingPositive(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMissingPositive().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 41. First Missing Positive";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getInsertPosition")
    public String getInsertPosition(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSearchInsertPosition().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 35. Search  Insert Position";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getDivideTwoIntegers")
    public String getDivideTwoIntegers(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getDivideTwoIntegers().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 29. Divide  Two Integers";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getMultiplyStrings")
    public String getMultiplyStrings(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMultiplyStrings().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 43. Multiply Strings";
        model.addAttribute("taskName", taskName);

        return "task";
    }


}
