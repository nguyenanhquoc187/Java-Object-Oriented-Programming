<#if package?? && package != "">
import java.util.Scanner;
package ${package};
public class ${name}<#if extension?? && extension != ""> extends ${extension}</#if><#if implementation?? && implementation != ""> implements ${implementation}</#if> {
    public static void main(String[] args) {
    }

}