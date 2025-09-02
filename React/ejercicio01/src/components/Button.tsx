import '../styles/Button.css'

type ButtonVariant = 
    | 'primary' 
    | 'secondary' 
    | 'disabled'
    | 'outlined'
    | 'outlined-secondary'
    | 'outlined-disabled';

type ButtonStyle = 'normal' | 'withIconLeft' | 'withIconRight';

interface ButtonProps {
    label: string;
    variant?: ButtonVariant;
    style?: ButtonStyle;
    disabled?: boolean;
    onClick?: () => void;
}

export const Button: React.FC<ButtonProps> = ({
    label,
    variant = 'primary',
    style = 'normal',
    disabled = false,
    onClick
}) => {
    const getIcon = () => {
        if (style === 'withIconLeft' || style === 'withIconRight') {
            return <span className="icon">+</span>;
        }
        return null;
    };

    const isDisabled = disabled || variant === 'disabled' || variant === 'outlined-disabled';

    return (
        <button
            className={`button ${variant} ${style}`}
            disabled={isDisabled}
            onClick={onClick}
        >
            {style === 'withIconLeft' && getIcon()}
            {label}
            {style === 'withIconRight' && getIcon()}
        </button>
    );
};