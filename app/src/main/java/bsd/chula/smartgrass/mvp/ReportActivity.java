package bsd.chula.smartgrass.mvp;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import org.parceler.Parcels;

import bsd.chula.smartgrass.R;
import bsd.chula.smartgrass.api.model.Work;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Dev_Tee on 5/15/17.
 */

public class ReportActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView mWebView;

    public static final String EXTRA_WORK = "EXTRA_WORK";

    private static final String RESULT = Environment.getExternalStorageDirectory().getAbsolutePath()
            + "/Report/Report.pdf";
    private Work mWork;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ButterKnife.bind(this);

        mWork = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_WORK));

        HTML_SRC = HTML_SRC.replace("{CustomerName}", mWork.getCustomerName() + " " + mWork.getCustomerLastname());

        mWebView.loadDataWithBaseURL(null, HTML_SRC, "text/html", "UTF-8", null);
    }

    private String HTML_SRC = "<!doctype html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>A simple, clean, and responsive HTML invoice template</title>\n" +
            "    \n" +
            "    <style>\n" +
            "    .invoice-box{\n" +
            "        max-width:800px;\n" +
            "        margin:auto;\n" +
            "        padding:30px;\n" +
            "        border:1px solid #eee;\n" +
            "        box-shadow:0 0 10px rgba(0, 0, 0, .15);\n" +
            "        font-size:16px;\n" +
            "        line-height:24px;\n" +
            "        font-family:'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n" +
            "        color:#555;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table{\n" +
            "        width:100%;\n" +
            "        line-height:inherit;\n" +
            "        text-align:left;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table td{\n" +
            "        padding:5px;\n" +
            "        vertical-align:top;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr td:nth-child(2){\n" +
            "        text-align:right;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.top table td{\n" +
            "        padding-bottom:20px;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.top table td.title{\n" +
            "        font-size:45px;\n" +
            "        line-height:45px;\n" +
            "        color:#333;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.information table td{\n" +
            "        padding-bottom:40px;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.heading td{\n" +
            "        background:#eee;\n" +
            "        border-bottom:1px solid #ddd;\n" +
            "        font-weight:bold;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.details td{\n" +
            "        padding-bottom:20px;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.item td{\n" +
            "        border-bottom:1px solid #eee;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.item.last td{\n" +
            "        border-bottom:none;\n" +
            "    }\n" +
            "    \n" +
            "    .invoice-box table tr.total td:nth-child(2){\n" +
            "        border-top:2px solid #eee;\n" +
            "        font-weight:bold;\n" +
            "    }\n" +
            "    \n" +
            "    @media only screen and (max-width: 600px) {\n" +
            "        .invoice-box table tr.top table td{\n" +
            "            width:100%;\n" +
            "            display:block;\n" +
            "            text-align:center;\n" +
            "        }\n" +
            "        \n" +
            "        .invoice-box table tr.information table td{\n" +
            "            width:100%;\n" +
            "            display:block;\n" +
            "            text-align:center;\n" +
            "        }\n" +
            "    }\n" +
            "    </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "    <div class=\"invoice-box\">\n" +
            "        <table cellpadding=\"0\" cellspacing=\"0\">\n" +
            "            <tr class=\"top\">\n" +
            "                <td colspan=\"2\">\n" +
            "                    <table>\n" +
            "                        <tr>\n" +
            "                            <td class=\"title\">\n" +
            "                                <img src=\"http://tcenter.acc.chula.ac.th/mmp/newcsblogoW.jpg\" style=\"width:100%; max-width:300px;\">\n" +
            "                            </td>\n" +
            "                            \n" +
            "                            <td>\n" +
            "                                Invoice #: {InvoiceID}<br>\n" +
            "                                Created: {DateCreate}<br>\n" +
            "                           \n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                    </table>\n" +
            "                </td>\n" +
            "            </tr>\n" +
            "            \n" +
            "            <tr class=\"information\">\n" +
            "                <td colspan=\"2\">\n" +
            "                    <table>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                BSD Organization, Inc.<br>\n" +
            "                                555 Chula Road<br>\n" +
            "                                Pathumwan, Bangkok, 10110\n" +
            "                            </td>\n" +
            "                            \n" +
            "                            <td>\n" +
            "                                {CustomerName}<br>\n" +
            "                                {Customer Address}<br>\n" +
            "                              \n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                    </table>\n" +
            "                </td>\n" +
            "            </tr>\n" +
            "                      \n" +
            "            <tr class=\"heading\">\n" +
            "                <td>\n" +
            "                    Item\n" +
            "                </td>\n" +
            "                \n" +
            "                <td>\n" +
            "                    Price\n" +
            "                </td>\n" +
            "            </tr>\n" +
            "            \n" +
            "            <tr class=\"item\">\n" +
            "                <td>\n" +
            "                    {Item}\n" +
            "                </td>\n" +
            "                \n" +
            "                <td>\n" +
            "                    {ItemPrice}\n" +
            "                </td>\n" +
            "            </tr>\n" +
            "            \n" +
            "          \n" +
            "            \n" +
            "            <tr class=\"total\">\n" +
            "                <td></td>\n" +
            "                \n" +
            "                <td>\n" +
            "                   Total: {Total}\n" +
            "                </td>\n" +
            "            </tr>\n" +
            "        </table>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";
}
