package org.softwire.training.bookish.controllers;


import org.softwire.training.bookish.models.database.Library;
import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.models.page.LibraryPageModel;
import org.softwire.training.bookish.models.page.MembersPageModel;
import org.softwire.training.bookish.services.LibraryService;
import org.softwire.training.bookish.services.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersController {

    private final MembersService membersService;

    @Autowired
    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @RequestMapping("")
    ModelAndView members() {

        List<Member> allMembers = membersService.getAllMembers();

        MembersPageModel membersPageModel = new MembersPageModel();
        membersPageModel.setMembers(allMembers);

        return new ModelAndView("member", "model", membersPageModel);
    }
}
