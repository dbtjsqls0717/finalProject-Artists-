package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.domain.UsersVO;


@Controller // ��Ʈ�ѷ� �� ����
public class MemberController {

	@Inject // ���񽺸� ȣ���ϱ� ���ؼ� �������� ����
	JavaMailSender mailSender; // ���� ���񽺸� ����ϱ� ���� �������� ������.

	// �α��� ���� ����
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String String = null;

	// �̸��� ���� ������ ���� �޼ҵ�
		@RequestMapping("/member/email")
		public void email(UsersVO vo , Model model) {
			model.addAttribute("id",vo.getId());
			model.addAttribute("pass",vo.getPass());
			model.addAttribute("name",vo.getName());
			model.addAttribute("nickname",vo.getNickname());
			model.addAttribute("phone",vo.getPhone());
			model.addAttribute("u_image",vo.getU_image());
			model.addAttribute("introduce",vo.getIntroduce());
			model.addAttribute("email",vo.getEmail());
		}

	
	// mailSending �ڵ�
	@RequestMapping(value = "/member/auth.do", method = RequestMethod.POST)
	@ResponseBody
	public int mailSending(HttpServletRequest request,String email,Model model,String e_mail, HttpServletResponse response_email)
			throws IOException {

		Random r = new Random();
		int dice = r.nextInt(4589362) + 49311; // �̸��Ϸ� �޴� �����ڵ� �κ� (����)
		String setfrom = "jungjaejae4885@gamil.com";
		String tomail = request.getParameter("e_mail"); // �޴� ��� �̸���
		String title = "ȸ������ ���� �̸��� �Դϴ�."; // ����
		String content =
				System.getProperty("line.separator") + // ���پ� �ٰ����� �α����� �ۼ�

						System.getProperty("line.separator") +

						"�ȳ��ϼ��� ȸ���� ���� Ȩ�������� ã���ּż� �����մϴ�"

						+ System.getProperty("line.separator") +

						System.getProperty("line.separator") +

						" ������ȣ�� " + dice + " �Դϴ�. "

						+ System.getProperty("line.separator") +

						System.getProperty("line.separator") +

						"������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�."; // ����

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
			messageHelper.setTo(tomail); // �޴»�� �̸���
			messageHelper.setSubject(title); // ���������� ������ �����ϴ�
			messageHelper.setText(content); // ���� ����

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

		ModelAndView mv = new ModelAndView(); // ModelAndView�� ���� �������� �����ϰ�, ����
												// ���� �����Ѵ�.
		mv.setViewName("/login/insert"); // �����̸�
		mv.addObject("dice", dice);
		
		/*
		 * //Data �� insert ���������� �޾ƿ��� model.addAttribute("id",vo.getId());
		 * model.addAttribute("pass",vo.getPass());
		 * model.addAttribute("name",vo.getName());
		 * model.addAttribute("nickname",vo.getNickname());
		 * model.addAttribute("phone",vo.getPhone());
		 * model.addAttribute("u_image",vo.getU_image());
		 * model.addAttribute("introduce",vo.getIntroduce());
		 * model.addAttribute("email",vo.getEmail());
		 */


		return dice;

	}

	
	// �̸��Ϸ� ���� ������ȣ�� �Է��ϰ� ���� ��ư�� ������ ���εǴ� �޼ҵ�.
	// ���� �Է��� ������ȣ�� ���Ϸ� �Է��� ������ȣ�� �´��� Ȯ���ؼ� ������ ȸ������ �������� �Ѿ��,
	// Ʋ���� �ٽ� ���� �������� ���ƿ��� �޼ҵ�
	@RequestMapping(value = "/member/join_injeung.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer join_injeung(String email_injeung,Model model,String dice,UsersVO vo,HttpServletResponse response_equals) throws IOException {
		int chk=-1;

		if (email_injeung.equals(dice)) {
			chk=1;
			 

		} else if (email_injeung != dice) {

			chk=0;
			 
		}
		return chk;

	}
	
}