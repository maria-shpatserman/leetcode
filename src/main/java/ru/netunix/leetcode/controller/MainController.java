package ru.netunix.leetcode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import ru.netunix.leetcode.service.Solution;

import java.io.IOException;
import java.nio.charset.Charset;

@Controller
@Slf4j
public class MainController {
    public Solution solution;
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
    @Autowired
    public MainController(Solution solution) {
        this.solution = solution;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/validAnagram")
    public String showAnswerValidAnagram(Model model) throws IOException {
        String s = "anagram";
        String t = "nagaram";
        Boolean anagram = solution.isAnagram(s, t);
        log.info("isAnagram for {}, {} result {}", s, t, anagram);
        String code = StreamUtils.copyToString(validAnagram.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);
        return "task-01";
    }

    @GetMapping("/mergeSortedArrays")
    public String showAnswerMergeSortedArrays(Model model) throws IOException {
        String code = StreamUtils.copyToString(mergeSortedArrays.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-02";
    }

    @GetMapping("/plusOne")
    public String showAnswerPlusOne(Model model) throws IOException {
        String code = StreamUtils.copyToString(plusOne.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-03";
    }
    @GetMapping("/sqrtX")
    public String showSqrtX(Model model) throws IOException {
        String code = StreamUtils.copyToString(sqrtX.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-04";
    }
    @GetMapping("/removeDuplicatesSortedList")
    public String showRemoveDuplicates(Model model) throws IOException {
        String code = StreamUtils.copyToString(rmvDuplicates.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-05";
    }
    @GetMapping("/getMajorityElement")
    public String getMajorityElement(Model model) throws IOException {
        String code = StreamUtils.copyToString(mjrElement.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-06";

    }
    @GetMapping("/containsDuplicateSecond")
    public String getContainsDuplicateSecond(Model model) throws IOException {
        String code = StreamUtils.copyToString(containsDuplicates2.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-07";

    }
    @GetMapping("/convertTheTemperature")
    public String getConvertTheTemperature(Model model) throws IOException{
        String code = StreamUtils.copyToString(convertTemperature.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-08";
    }
    //todo refactoring remove enormous amount of task- html make template with variable
    @GetMapping("/getTwoSumIndexes")
    public String getTwoSumIndexes(Model model) throws IOException{
        String code = StreamUtils.copyToString(twoSum.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-09";
    }
    @GetMapping("/getAddTwoNumbersLinkedList")
    public String getAddTwoNumbersLinkedList(Model model) throws IOException{
        String code = StreamUtils.copyToString(addTwoNumbers.getInputStream(), Charset.defaultCharset());
        model.addAttribute("code", code);

        return "task-10";
    }
}
