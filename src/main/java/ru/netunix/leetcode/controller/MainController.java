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
    MainController(Config configuration) {
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
    @GetMapping("/addDigits")
    public String getAddDigits(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getAddDigits().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 258. add digits";
        model.addAttribute("taskName", taskName);

        return "task";
    }

    @GetMapping("/pascalTriangle")
    public String getPascalTriangle(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getPascalTriangle().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 118. Pascal's Triangle";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/pascalTriangleTwo")
    public String getPascalTriangleTwo(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getPascalTriangleTwo().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 119. Pascal's Triangle II";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/singleNumber")
    public String getSingleNumber(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSingleNumber().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 136. Single Number";
        model.addAttribute("taskName", taskName);

        return "task";
    }

    @GetMapping("/addBinary")
    public String getAddBinary(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getAddBinary().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 67. Add Binary";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/linkedListCycle")
    public String getLinkedListCycle(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLinkedListCycle().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 141. Linked List Cycle";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/pathCrossing")
    public String getPathCrossing(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getPathCrossing().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 1496. Path Crossing";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/countBinaryTreeNodes")
    public String getCountBinaryTreeNodes(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getCountBinaryTreeNodes().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 222. Count Complete Tree Nodes";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/summaryRanges")
    public String getSummaryRanges(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getSummaryRanges().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 228. Summary Ranges";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/buyAndSell")
    public String getBuyAndSell(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getBuyAndSell().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 121. Best Time to Buy and Sell Stock";
        model.addAttribute("taskName", taskName);

        return "task";
    }
    @GetMapping("/pathSum")
    public String getPathSum(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getPathSum().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 112. Path Sum";
        model.addAttribute("taskName", taskName);

        return "task";
    }





}
