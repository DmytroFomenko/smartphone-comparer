package dfomenko.controller;

import dfomenko.entity.Smartphone;
import dfomenko.service.CompanyService;
import dfomenko.service.ModelService;
import dfomenko.service.SmartphoneService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class SmartphoneController {

    private final SmartphoneService smartphoneService;
    private final CompanyService companyService;
    private final ModelService modelService;
    private final String NAME_DASH = "-";


    @GetMapping("/smartphones")
    public String listSmartphones(@ModelAttribute("error") String error,
                                  @ModelAttribute("chosenCompanyId") String chosenCompanyIdStr,
                                  @ModelAttribute("chosenModelId") String chosenModelIdStr,
                                  @ModelAttribute("chosenCompanyId2") String chosenCompanyIdStr2,
                                  @ModelAttribute("chosenModelId2") String chosenModelIdStr2,
                                Model model,
                                HttpSession session) {

        model.addAttribute("smartphones", smartphoneService.findAllSmartphones());
        model.addAttribute("companies", companyService.findAllCompanies());
        model.addAttribute("modelServ", modelService);
        model.addAttribute("companyServ", companyService);

        Long chosenCompanyId;
        Long chosenModelId;
        Long emptyCompanyId = companyService.findCompanyIdByCompanyName(NAME_DASH);
        Long emptyModelId = modelService.findModelIdByModelName(NAME_DASH);


        if (chosenCompanyIdStr.isEmpty()) {
            Object o1 = session.getAttribute("chosenCompanyId");
            if (o1 != null) {
                chosenCompanyIdStr = o1.toString();
            }
        }
        if (chosenModelIdStr.isEmpty()) {
            Object o2 = session.getAttribute("chosenModelId");
            if (o2 != null) {
                chosenModelIdStr = o2.toString();
            }
        }

        if (chosenCompanyIdStr == null
            || chosenCompanyIdStr.isEmpty()) {
            chosenCompanyId = emptyCompanyId;
        } else {
            chosenCompanyId = Long.parseLong(chosenCompanyIdStr);
        }

        if (chosenModelIdStr == null
                || chosenModelIdStr.isEmpty()) {
            chosenModelId = emptyModelId;
        } else {
            chosenModelId = Long.parseLong(chosenModelIdStr);
        }

        model.addAttribute("chosenCompanyId", chosenCompanyId);
        session.setAttribute("chosenCompanyId", chosenCompanyId);

        model.addAttribute("chosenModelId", chosenModelId);
        session.setAttribute("chosenModelId", chosenModelId);



        Long chosenCompanyId2;
        Long chosenModelId2;

        if (chosenCompanyIdStr2.isEmpty()) {
            Object o3 = session.getAttribute("chosenCompanyId2");
            if (o3 != null) {
                chosenCompanyIdStr2 = o3.toString();
            }
        }
        if (chosenModelIdStr2.isEmpty()) {
            Object o4 = session.getAttribute("chosenModelId2");
            if (o4 != null) {
                chosenModelIdStr2 = o4.toString();
            }
        }

        if (chosenCompanyIdStr2 == null || chosenCompanyIdStr2.isEmpty()) {
            chosenCompanyId2 = emptyCompanyId;
        } else {
            chosenCompanyId2 = Long.parseLong(chosenCompanyIdStr2);
        }

        if (chosenModelIdStr2 == null
                || chosenModelIdStr2.isEmpty()) {
            chosenModelId2 = emptyModelId;
        } else {
            chosenModelId2 = Long.parseLong(chosenModelIdStr2);
        }

        model.addAttribute("chosenCompanyId2", chosenCompanyId2);
        session.setAttribute("chosenCompanyId2", chosenCompanyId2);

        model.addAttribute("chosenModelId2", chosenModelId2);
        session.setAttribute("chosenModelId2", chosenModelId2);


        model.addAttribute("models", modelService.findModelsByCompanyId(chosenCompanyId));
        model.addAttribute("models2", modelService.findModelsByCompanyId(chosenCompanyId2));

        Smartphone smartphone1 = smartphoneService.findByCompanyIdAndModelId(chosenCompanyId, chosenModelId);
        Smartphone smartphone2 = smartphoneService.findByCompanyIdAndModelId(chosenCompanyId2, chosenModelId2);
        Smartphone zeroCharacteristicsSmartphone = new Smartphone().createZeroCharacteristicsSmartphone();

        if (smartphone1 == null) {
            smartphone1 = zeroCharacteristicsSmartphone;
        }
        model.addAttribute("smartphone1", smartphone1);

        if (smartphone2 == null) {
            smartphone2 = zeroCharacteristicsSmartphone;
        }
        model.addAttribute("smartphone2", smartphone2);


        return "smartphones";
    }


    @PostMapping("/choose_smartphone")
    public String chooseSmartphone(RedirectAttributes redirectAttributes,
                                   @ModelAttribute("orderCompanyId") String orderCompanyIdStr,
                                   @ModelAttribute("orderModelId") String orderModelIdStr,
                                   @ModelAttribute("orderCompanyId2") String orderCompanyIdStr2,
                                   @ModelAttribute("orderModelId2") String orderModelIdStr2) {


        String emptyModelIdString = modelService.findModelIdByModelName(NAME_DASH).toString();

        if (!Objects.equals(orderCompanyIdStr, "")) {
            orderModelIdStr = emptyModelIdString;
        }

        if (!Objects.equals(orderCompanyIdStr2, "")) {
            orderModelIdStr2 = emptyModelIdString;
        }

        redirectAttributes.addFlashAttribute("chosenCompanyId", orderCompanyIdStr);
        redirectAttributes.addFlashAttribute("chosenModelId", orderModelIdStr);

        redirectAttributes.addFlashAttribute("chosenCompanyId2", orderCompanyIdStr2);
        redirectAttributes.addFlashAttribute("chosenModelId2", orderModelIdStr2);

        return "redirect:/smartphones";
    }






}
