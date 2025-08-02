package ru.netunix.leetcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import ru.netunix.leetcode.config.HardConfig;

import java.io.IOException;
import java.nio.charset.Charset;

@Controller
@Slf4j
public class HardController {
    private HardConfig configuration;
    @Autowired
    HardController(HardConfig configuration){
        this.configuration = configuration;
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
    @GetMapping("/getMergedKSortedLists")
    public String getMergedKSortedLists(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getMergeKSortedLists().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 23. Merge k Sorted Lists";
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
    @GetMapping("/getLongestValidParentheses")
    public String getLongestValidParentheses(Model model) throws IOException {
        String code = StreamUtils.copyToString(configuration.getLongestValidParentheses().getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        //taskName
        String taskName = "Task 32. Longest Valid Parentheses";
        model.addAttribute("taskName", taskName);

        return "task";
    }
}
