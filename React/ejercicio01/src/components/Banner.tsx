import '../styles/Banner.css'

interface BannerProps {
    title: string;
    description: string;
    buttonText: string;
    onButtonClick?: () => void;
}

export const Banner: React.FC<BannerProps> = ({ 
    title, 
    description, 
    buttonText, 
    onButtonClick 
}) => {
    return (
        <div className="banner">
            <div className="banner-content">
                <h1 className="banner-title">{title}</h1>
                <p className="banner-description">{description}</p>
                <button className="banner-button" onClick={onButtonClick}>
                    {buttonText}
                </button>
            </div>
        </div>
    );
};