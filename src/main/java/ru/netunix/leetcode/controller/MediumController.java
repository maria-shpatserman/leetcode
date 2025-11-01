package ru.netunix.leetcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import ru.netunix.leetcode.config.MediumConfig;

import java.io.IOException;
import java.nio.charset.Charset;

@Controller
@Slf4j
public class MediumController {
    MediumConfig configuration;
    @Autowired MediumController(MediumConfig configuration){
        this.configuration = configuration;
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



    @GetMapping("/getSwappedNodesInPairs")
    public String getSwappedNodesInPairs(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSwappedNodesInPairs().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 24. Swap Nodes In Pairs";
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

    @GetMapping("/getElementInSortedArray")
    public String getElementInSortedArray(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getFindElementInSortedArray().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 34. Find First and Last Position of Element in Sorted Array";
        model.addAttribute("taskName", taskName);

        return "task";
    }



    @GetMapping("/getNextPermutation")
    public String getNextPermutation(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getNextPermutation().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 31. Next Permutation";
        model.addAttribute("taskName", taskName);

        return "task";
    }

    @GetMapping("/getSearchInRotatedSortedArray")
    public String getSearchInRotatedSortedArray(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSearchInRotatedArray().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 33. Search in Rotated Sorted Array";
        model.addAttribute("taskName", taskName);

        return "task";
    }

    @GetMapping("/getCountAndSay")
    public String getCountAndSay(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getCountAndSay().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 38. Count And Say";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/getDeleteNodesFromList")
    public String getDeleteNodesFromList(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getDeleteNodesFromList().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 3217. Delete Nodes From Linked List Present in Array";
        model.addAttribute("taskName", taskName);

        return "task";
    }
}
